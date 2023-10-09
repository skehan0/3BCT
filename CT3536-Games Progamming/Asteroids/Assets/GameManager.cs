using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    public int currentGameLevel = 1; // Set the starting game level
    public GameObject asteroidPrefab; // Reference to the asteroid prefab

    void Start()
    {
        // Set the camera's position
        Camera.main.transform.position = new Vector3(0f, 30f, 0f);
        Camera.main.transform.LookAt(new Vector3(0f, 0f, 0f), Vector3.up);

        // Call the method to start a new level
        StartNewLevel();
    }

    // Method to start a new game level
    void StartNewLevel()
    {
        // Calculate the number of asteroids based on the current game level
        int numAsteroids = currentGameLevel * 3; 

        for (int i = 0; i < numAsteroids; i++)
        {
            // Generate a random spawn position within the screen boundaries
            Vector3 spawnPosition = new Vector3(Random.Range(-15f, 15f), 0f, Random.Range(-15f, 15f));

            // Ensure the Y position is at ground level (0)
            spawnPosition.y = 0f;

            // Add a buffer to the Z position to prevent immediate wrap-around
            spawnPosition.z += 2f;

            // Instantiate asteroid
            Instantiate(asteroidPrefab, spawnPosition, Quaternion.identity);
        }
    }
}
