// function test(){
//     console.log("just testing java script")
// }
//
// function changePage(){
//     location.href = "dashboard.html";
// }

function submitFunctionAlumniDetails() {
    // Getting values
    let alumniLogin = 1;
    let email = document.getElementById("email").value;
    let contact = document.getElementById("contact").value;
    let degree = document.getElementById("degree").value;
    let collage_name = document.getElementById("collage_name").value;
    let position = document.getElementById("position").value;

    let obj = {
        email : email,
        contact: contact,
        degree: degree,
        collage_name: collage_name,
        position: position,
        alumniLogin:alumniLogin
    };
    console.log(obj)

    // Send to Backend
    fetch("http://localhost:8080/AlumniDetailsUpdateNew_war/api/AlumniDetails/addDetails", {
        // Adding method type
        method: "POST",
        // Adding body or contents to send
        body: JSON.stringify(obj),
        // Adding headers to the request
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    })
        // Converting to JSON
        .then((response) => response.json())

        // Displaying results to console
        .then((json) => {
            console.log(json)

            // Popup
            Swal.fire({
                title: 'Submitted!',
                text: 'Details has been submitted',
                icon: 'success',
                confirmButtonText: 'Okay'
            })
        });
}

async function getapi(url) {

    // Storing response
    const response = await fetch(url);

    // Storing data in form of JSON
    var data = await response.json();
    // console.log(data);
    if (response) {
        document.getElementById("email").value = data[0].email;
        document.getElementById("contact").value = data[0].contact;
        document.getElementById("degree").value = data[0].degree;
        document.getElementById("collage_name").value = data[0].collage_name;
        document.getElementById("position").value = data[0].position;
    }
    show(data);
}

function getDetails(){
    var id = document.getElementById('id').value;
    getapi("http://localhost:8080/AlumniDetailsUpdateNew_war/api/AlumniDetails/"+ id + "/getDetails");
}

async function deleteApi(url){
    const  response  = await fetch(url,{
        method: 'DELETE',
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });
    console.log(response);
}

function deleteDetails(){
    var delId = document.getElementById('delId').value;
    deleteApi("http://localhost:8080/AlumniDetailsUpdateNew_war/api/AlumniDetails/" + delId+"/deleteDetails");
}

function appendData(data) {
    var mainContainer = document.getElementById("myData");
    for (var i = 0; i < data.length; i++) {
        var div = document.createElement("div");
        div.innerHTML = 'id: ' + data[i].AlumniDetails_id + 'Email: ' + data[i].email + ' Contact: ' + data[i].contact + ' Degree: ' + data[i].degree + 'Collage Name: ' + data[i].collage_name + ' position: ' + data[i].position;
        mainContainer.appendChild(div);
    }
}

function showAllData(){
    fetch("http://localhost:8080/AlumniDetailsUpdateNew_war/api/AlumniDetails/getAllDetails")
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            appendData(data);
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });
}

async function updateApi(url){
    const  response  = await fetch(url,{
        method: 'POST',
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: {}
    });
    console.log(response);
}

function updateDetails(){
    // Getting values
    let updateId = document.getElementById("id").value;
    let email = document.getElementById("email").value;
    let contact = document.getElementById("contact").value;
    let degree = document.getElementById("degree").value;
    let collage_name = document.getElementById("collage_name").value;
    let position = document.getElementById("position").value;

    let obj = {
        email : email,
        contact: contact,
        degree: degree,
        collage_name: collage_name,
        position: position
    };
    console.log(obj)

    // Send to Backend
    fetch("http://localhost:8080/AlumniDetailsUpdateNew_war/api/AlumniDetails/"+ updateId +"/updateDetails", {
        // Adding method type
        method: "POST",
        // Adding body or contents to send
        body: JSON.stringify(obj),
        // Adding headers to the request
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    })
        // Converting to JSON
        .then((response) => response.json())

        // Displaying results to console
        .then((json) => {
            console.log(json)

            // Popup
            Swal.fire({
                title: 'Submitted!',
                text: 'Details has been submitted',
                icon: 'success',
                confirmButtonText: 'Okay'
            })
        });
}