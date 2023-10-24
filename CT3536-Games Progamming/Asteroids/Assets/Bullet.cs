using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    public float bulletSpeed = 10.0f;

    // You might want to add a reference to an impact effect prefab.
    public GameObject impactEffect;

    // This method is called when the bullet is created.
    public void FireBullet(Vector3 direction)
    {
        // Set the initial velocity of the bullet based on the direction and speed.
        GetComponent<Rigidbody>().velocity = direction * bulletSpeed;
    }

    // This method is called when a collision occurs.
    private void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.CompareTag("Asteroid"))
        {
            // Handle asteroid collisions (e.g., destroy the asteroid and play an impact effect).
            Destroy(collision.gameObject); // Destroy the asteroid.

            if (impactEffect != null)
            {
                Instantiate(impactEffect, transform.position, Quaternion.identity);
            }
            Destroy(gameObject); // Destroy the bullet.
        }
    }

    void Update()
    {
        CheckScreenEdges();
    }

    void CheckScreenEdges()
    {
        // Check if the bullet has left the screen
        if (Mathf.Abs(transform.position.x) > 25f || Mathf.Abs(transform.position.z) > 25f)
        {
            Destroy(gameObject); // Destroy the bullet. 
        }
    }
}
