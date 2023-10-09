using System.Collections;
using System.Collections.Generic;
using UnityEngine;
public class AsteroidScript : MonoBehaviour
{
    private float destroyMinX;
    // Use this for initialization
    void Start()
    {
        Rigidbody r = GetComponent<Rigidbody>();
        r.velocity = new Vector3(50f + Random.Range(5f, 15f), 0f, 0f);
        r.AddTorque(new Vector3(Random.Range(5f, 15f), Random.Range(5f, 15f), Random.Range
        (5f, 15f)));
        InvokeRepeating("CheckForOffscreen", 3f, 1f);
        destroyMinX = Mathf.Abs(transform.position.x); // transform.position.x will be a
        negative value
    Debug.Log("Asteroid spawned: " + GetInstanceID() + " with destroyMinX=" + destroy
    MinX);
    }
    void OnTriggerEnter(Collider other)
    {
        if (other.name != "SpawnRegion")
        {
            Debug.Log("Asteroid destroyed by collision: " + GetInstanceID());
            GameObject.Destroy(this.gameObject);
        }
    }
    private void CheckForOffscreen()
    {
        if (transform.position.x > destroyMinX)
        {
            Vector3 viewPos = Camera.main.WorldToViewportPoint(transform.position);
            if (viewPos.x > 1f || viewPos.x < 0f || viewPos.y > 1f || viewPos.y < 0f || viewPos.
            z < 0f)
            {
                Debug.Log("Asteroid destroyed by going offscreen: " + GetInstanceID());
                GameObject.Destroy(this.gameObject);
            }
        }
    }
}