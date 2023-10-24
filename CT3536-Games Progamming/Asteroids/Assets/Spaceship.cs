using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spaceship : MonoBehaviour
{
    public float upForce = 8f;  // Adjust the force for forward acceleration.
    public float rotationSpeed = 5f;  // Adjust the rotation speed.
    private Rigidbody rb;
    public GameObject bulletPrefab;
    public float bulletSpeed = 10.0f;
    public float fireRate = 4.0f;
    private float nextFireTime;

    private void Start()
    {
        // Get the Rigidbody component attached to the spaceship.
        rb = GetComponent<Rigidbody>();

        InvokeRepeating("CheckScreenEdges", 0f, 0.2f);
    }

    private void Update()
    {
        // Accelerate forward when the Up arrow is held.
        if (Input.GetKey(KeyCode.UpArrow))
        {
            // Apply a forward force to the spaceship.
            rb.AddForce(transform.up * upForce);
        }

        // Rotate left when the Left arrow is held.
        if (Input.GetKey(KeyCode.LeftArrow))
        {
            Vector3 currentRotation = transform.rotation.eulerAngles;
            currentRotation.y -= 100 * Time.deltaTime;
            transform.rotation = Quaternion.Euler(currentRotation);
        }

        // Rotate right when the Right arrow is held.
        if (Input.GetKey(KeyCode.RightArrow))
        {
            Vector3 currentRotation = transform.rotation.eulerAngles;
            currentRotation.y += 100 * Time.deltaTime;
            transform.rotation = Quaternion.Euler(currentRotation);
        }

        // Fire Bullet
        if (Input.GetKeyDown(KeyCode.Space))
        {
            if (Time.time > nextFireTime)
            {
                FireBullet();
                nextFireTime = Time.time + 1.0f * fireRate;
            }
        }

    }

    void CheckScreenEdges()
    {
        Debug.Log("Current position: " + transform.position);
        // Check if the asteroid has left the screen
        if (Mathf.Abs(transform.position.x) > 30f || Mathf.Abs(transform.position.z) > 30f)
        {
            // Wrap around to the opposite side
            transform.position = new Vector3(-transform.position.x, 0, -transform.position.z);
        }
    }

    void FireBullet()
    {
        GameObject bullet = Instantiate(bulletPrefab, transform.position, transform.rotation);
        Vector3 bulletDirection = transform.up;
        bullet.GetComponent<Bullet>().FireBullet(bulletDirection);
    }
}