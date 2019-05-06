using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spawnball : MonoBehaviour
{

   // [SerializeField]
    //public GameObject ball;

    public void Spawn()
    {
        //Vector3 newPos = new Vector3(0.0f, 1.03f, -9.21f);
        //transform.position = newPos;
        transform.localScale += new Vector3(2f, 2f, 2f);

        //Debug.Log("Spawn ball button pressed!");
        ////Instantiate(ball, new Vector3(0f, 0f, 0f), Quaternion.identity);
        //Instantiate(ball, new Vector3(0f, 1f, 1f), Quaternion.identity);
    }
}