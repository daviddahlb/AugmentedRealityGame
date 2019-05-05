using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spawnball : MonoBehaviour
{

    [SerializeField]
    public GameObject ball;

    public void Spawn()
    {
        Debug.Log("Spawn ball button pressed!");
        //Instantiate(ball, new Vector3(0f, 0f, 0f), Quaternion.identity);
        Instantiate(ball, new Vector3(0f, 1f, 1f), Quaternion.identity);
    }
}