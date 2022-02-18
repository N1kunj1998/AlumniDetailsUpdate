let login_form = document.getElementById('login-validation');

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();

    if (login_form.checkValidity() === true) {
        let response = await fetch('http://localhost:8080/AlumniDetailsUpdateNew_war/api/Alumni/verify/', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                username: document.getElementById('username').value,
                password: document.getElementById('password').value
            })
        });

        try{
            let result = await response.json();
            console.log(result);
            console.log(response);
            sessionStorage.setItem("id",result);
            location.href = "dashboard.html";
        }catch(err){
            document.getElementById("login-alert").style.display = "block";
        }
    }
});

function addLogin(){
        // Getting values
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;

        let obj = {
            username : username,
            password : password
        };

        console.log(JSON.stringify(obj));

        // Send to Backend
        fetch("http://localhost:8080/AlumniDetailsUpdateNew_war/api/Alumni/addAlumni", {
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
