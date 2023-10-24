using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Asteroid : MonoBehaviour
{
    Rigidbody rb;
    public float moveSpeed = 6f;
    public GameObject smallAsteroidPrefab;
    public int numSmallAsteroidsToSpawn = 2; // Number of small asteroids to spawn on collision.
    public GameObject playerShipPrefab; // Reference to the player ship prefab.

    void Start()
    {
        rb = GetComponent<Rigidbody>();

        // Calculate a random direction vector on the XZ plane
        Vector3 randomDirection = Random.onUnitSphere;
        randomDirection.y = 0f;

        // Set the initial velocity based on your moveSpeed
        rb.velocity = randomDirection * moveSpeed;

        // Generate random torque (angular velocity)
        Vector3 randomTorque = new Vector3(
            Random.Range(5f, 15f),
            Random.Range(5f, 15f),
            Random.Range(5f, 15f)
        );

        InvokeRepeating("CheckScreenEdges", 0f, 0.2f);
    }

    void CheckScreenEdges()
    {
        Debug.Log("Current position: " + transform.position);
        // Check if the asteroid has left the screen
        if (Mathf.Abs(transform.position.x) > 25f || Mathf.Abs(transform.position.z) > 25f)
        {
            // Wrap around to the opposite side
            transform.position = new Vector3(-transform.position.x, 0, -transform.position.z);
        }
    }

    private void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.CompareTag("Player"))
        {
            // Destroy the player's ship.
            Destroy(collision.gameObject);

            // Re-create the player's ship in the center of the screen.
            RespawnPlayerShip();
        }
        else if (collision.gameObject.CompareTag("Bullet"))
        {
            // Destroy the bullet.
            Destroy(collision.gameObject);
            SpawnSmallAsteroids(collision.contacts[0].point);

            if (gameObject.CompareTag("Asteroid"))
            {
                // The asteroid was large; spawn small asteroids at the collision point.
                SpawnSmallAsteroids(collision.contacts[0].point);
            }
        }
    }

    private void SpawnSmallAsteroids(Vector3 spawnPosition)
    {
        for (int i = 0; i < numSmallAsteroidsToSpawn; i++)
        {

            // Instantiate small asteroid prefab at the collision point.
            GameObject smallAsteroidInstance = Instantiate(smallAsteroidPrefab, spawnPosition, Quaternion.identity);

            // Apply some random velocity to the small asteroids.
            Vector3 randomDirection = Random.onUnitSphere;
            randomDirection.y = 0f;
            smallAsteroidInstance.GetComponent<Rigidbody>().velocity = randomDirection * moveSpeed;

            Destroy(smallAsteroidInstance, 2f);
        }
    }

    private void RespawnPlayerShip()
    {
        // Re-create the player ship in the center of the screen.
        Quaternion rot = Quaternion.Euler(90, 0, 0);
        Instantiate(playerShipPrefab, Vector3.zero, rot);
    }
}

