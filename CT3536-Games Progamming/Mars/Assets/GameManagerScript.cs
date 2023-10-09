using System.Collections;
using System.Collections.Generic;
using UnityEngine;
public class GameManager : MonoBehaviour
{
    // inspector values
    public GameObject mars;
    public GameObject phobos, deimos;
    public GameObject asteroidPrefab;
    public BoxCollider asteroidSpawnRegion;
    //
    public static GameManager instance;
    // Use this for initialization
    void Start()
    {
        Camera.main.transform.position = new Vector3(0f, 0f, -200f);
        Camera.main.transform.LookAt(mars.transform);
        mars.GetComponent<Rigidbody>().AddTorque(new Vector3(0f, 20f, 0f));
        instance = this;
    }
    // Update is called once per frame
    void Update()
    {
        phobos.transform.RotateAround(Vector3.zero, Vector3.up, 3f * Time.deltaTime);
        deimos.transform.RotateAround(Vector3.zero, Vector3.up, 2f * Time.deltaTime);
        // NB we are using the camera's own coordinate system (rather than the global co
        ordinate system) to specify the axis of rotation
    if (Input.GetKey(KeyCode.LeftArrow))
            Camera.main.transform.RotateAround(Vector3.zero, Camera.main.transform.up,
            50f * Time.deltaTime);
        else if (Input.GetKey(KeyCode.RightArrow))
            Camera.main.transform.RotateAround(Vector3.zero, Camera.main.transform.up,
            -50f * Time.deltaTime);
        if (Input.GetKey(KeyCode.UpArrow))
            Camera.main.transform.RotateAround(Vector3.zero, Camera.main.transform.right, 50f * Time.deltaTime);
        else if (Input.GetKey(KeyCode.DownArrow))
            Camera.main.transform.RotateAround(Vector3.zero, Camera.main.transform.right, -50f * Time.deltaTime);
        // maybe spawn a new asteroid (one every three seconds, on average)
        if (Random.Range(0f, 1f) < Time.deltaTime / 3f)
        {
            GameObject go = GameObject.Instantiate(asteroidPrefab);
            go.transform.position = ChooseAsteroidSpawnPoint();
        }
    }
    private Vector3 ChooseAsteroidSpawnPoint()
    {
        return new Vector3(Random.Range(asteroidSpawnRegion.bounds.min.x, asteroidSpaw
        nRegion.bounds.max.x),
        Random.Range(asteroidSpawnRegion.bounds.min.y, asteroidSpawnRegion.bounds.max.y),
        Random.Range(asteroidSpawnRegion.bounds.min.z, asteroidSpawnRegion.bounds.max.z));
    }
}