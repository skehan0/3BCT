using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class GameManager : MonoBehaviour
{
    public enum GameState
    {
        Menu,
        Playing
    }

    public GameState gameState = GameState.Menu;
    private int score = 0;
    private int highScore = 0;
    private int lives = 3; 
    public TextMeshProUGUI scoreText;
    public TextMeshProUGUI highScoreText;
    public TextMeshProUGUI livesText;
    public GameObject menuCanvas;
    public GameObject gameCanvas;
    public Button playButton;

    public int currentGameLevel = 1;
    public GameObject asteroidPrefab;
    public GameObject spaceshipPrefab;
    public GameObject bulletPrefab;

    List<GameObject> activeAsteroids = new List<GameObject>();

    void Start()
    {
        // Set the camera's position
        Camera.main.transform.position = new Vector3(0f, 40f, 0f);
        Camera.main.transform.LookAt(new Vector3(0f, 0f, 0f), Vector3.up);

        if (gameState == GameState.Menu)
        {
            DisplayMenuGUI();
        }

        CreatePlayerSpaceship();

        // Start button's click event.
        playButton.onClick.AddListener(PlayButtonClicked);

        // Call the method to start a new level
        StartNewLevel();
    }

    void StartNewLevel()
    {
        score = 0;

        // Destroy all leftover asteroids from the previous game
        DestroyLeftoverAsteroids();

        currentGameLevel++;
        AddToScore(10);

        // Calculate the number of asteroids based on the current game level
        int numAsteroids = currentGameLevel + 1;

        for (int i = 0; i < numAsteroids; i++)
        {
            // Generate a random spawn position within the screen boundaries
            Vector3 spawnPosition = new Vector3(Random.Range(-15f, 15f), 0f, Random.Range(-15f, 15f));

            // Ensure the Y position is at ground level (0)
            spawnPosition.y = 0f;

            // Add a buffer to the Z position to prevent immediate wrap-around
            spawnPosition.z += 2f;

            // Instantiate asteroid
            GameObject asteroid = Instantiate(asteroidPrefab, spawnPosition, Quaternion.identity);
            activeAsteroids.Add(asteroid);
        }
    }

    void CreatePlayerSpaceship()
    {
        Quaternion rot = spaceshipPrefab.transform.rotation;
        Instantiate(spaceshipPrefab, Vector3.zero, rot);
    }

    void DisplayMenuGUI()
    {
        // Enable or disable UI elements
        menuCanvas.SetActive(true);
        gameCanvas.SetActive(false);
        playButton.gameObject.SetActive(true);


        // Attach button click handlers
        playButton.onClick.AddListener(PlayButtonClicked);
    }

    void PlayButtonClicked()
    {
        // Switch the game state to "Playing."
        gameState = GameState.Playing;

        // Disable the menu canvas and enable the game canvas.
        menuCanvas.SetActive(false);
        gameCanvas.SetActive(true);

        // Call the StartNewGame() method.
        StartNewLevel();
    }

    void UpdateScoreGUI()
    {
        if (scoreText != null)
        {
            scoreText.text = "Score: " + score.ToString();
        }

        if (highScoreText != null)
        {
            highScoreText.text = "High Score: " + highScore.ToString();
        }

        if (livesText != null)
        {
            livesText.text = "Lives: " + lives.ToString();
        }
    }

    void AddToScore(int points)
    {
        score += points;

        // Update the high score if the current score is higher.
        if (score > highScore)
        {
            highScore = score;
        }

        UpdateScoreGUI();
    }

    // Decrease the player's lives and end the game if no lives are left.
    void DecreaseLives()
    {
        lives--;

        if (lives <= 0)
        {
            // Game over, switch back to the menu.
            gameState = GameState.Menu;
            DisplayMenuGUI();
        }
        else
        {
            // Update the UI to show the remaining lives.
            UpdateScoreGUI();
        }
    }

    // Method to destroy all leftover asteroids from the previous game
    void DestroyLeftoverAsteroids()
    {
        foreach (GameObject asteroid in activeAsteroids)
        {
            if (asteroid != null)
            {
                Destroy(asteroid);
            }
        }

        activeAsteroids.Clear();
    }
}
