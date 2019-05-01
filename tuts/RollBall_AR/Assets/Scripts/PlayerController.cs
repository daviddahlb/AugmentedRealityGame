using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerController : MonoBehaviour
{
    public float speed;
    public Text countText;
    public Text winText;

    private Rigidbody rb;
    private int count;
    private Vector2 touchStart, touchEnd;
    
    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        count = 0;
        SetCountText();
        winText.text = "";
    }

    void Update()
    {
        // Swipe start
        if (Input.touchCount == 1 && Input.GetTouch(0).phase == TouchPhase.Began)
        {
            touchStart = Input.GetTouch(0).position;
        }
        // Swipe end
        if (Input.touchCount == 1 && Input.GetTouch(0).phase == TouchPhase.Ended)
        {
            touchEnd = Input.GetTouch(0).position;
            float cameraFacing = Camera.main.transform.eulerAngles.y;
            Vector2 swipeVector = touchEnd - touchStart;
            Vector3 inputVector = new Vector3(swipeVector.x, 0.0f, swipeVector.y);
            Vector3 movement = Quaternion.Euler(0.0f, cameraFacing, 0.0f) * Vector3.Normalize(inputVector);
            rb.velocity = movement;
        }
    }

    void OnTriggerEnter(Collider other)
    {
        //tag allows us to identify a gameobject by its value
        //set Active deactivates/activates, instead of deleting
        //compare lets us comapre tag with a string value, more effiecient than just tag
        if (other.gameObject.CompareTag("Pick Up"))
        {
            other.gameObject.SetActive(false);
            count = count + 1;
            SetCountText();
        }
    }

    void SetCountText()
    {
        countText.text = "Count: " + count.ToString();
        if(count >= 11)
        {
            winText.text = "You Win!";
        }
    }
}

//other is whatever gameobject we have colided with (Collider type), and is destroyed cascadely
//Destroy(other.gameObject);