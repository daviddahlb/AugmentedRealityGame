using UnityEngine;
using UnityEngine.SceneManagement;
using System.Collections;

public class RestartScene : MonoBehaviour
{

    public void RestartGame()
    {
        Debug.Log("RestartScene script hit!");
        SceneManager.LoadScene(SceneManager.GetActiveScene().name); // loads current scene
    }

}