//
//function handleLogin(event) {
//    event.preventDefault();
//
//    // Get user input
//    const email = document.getElementById("email").value;
//    const password = document.getElementById("password").value;
//console.log("Email Are : "email,"\n","Password Are :",password);
//    const user = {
//        email: email,
//        password: password
//    };
//
//    fetch('http://localhost:8080/api/v1/users/login', {
//        method: 'POST',
//        headers: {
//            'Content-Type': 'application/json'
//        },
//        body: JSON.stringify(user)
//    }).then(response => {
//        if (!response.ok) {
//            alert('Login and / or password is incorrect');
//        }
//        return response.json();
//    }).then((response) => {
//        localStorage.setItem('connectedUser', JSON.stringify(response));
//        window.location.href = 'index.html'
//    }).catch(error => {
//        console.error('POST request error', error);
//    });
//}
//
//
//
//const loginForm = document.getElementById("loginForm");
//loginForm.addEventListener("submit", handleLogin);


function handleLogin(event){
    event.preventDefault();
    const email:HTMlElement = document.getElementById("email").value;
    const password:HTMlElement=document.getElementById("password").value;

    const user:{}={
        email:email,
        password:password
    };

    fetch(url='http://localhost:8080/api/v1/users/login',{
    method:'POST',
    headers:{
    'Content-Type' : 'application/json'
    },
    body:JSON.stringify(user)
    }).then(response: Response =>{
    if(!response.ok){
    alert("Login and / or Password Is Incorrect ");
    }
    return response.json();
    }).then((response) =>{
    localStorage.setItem('connectedUser', JSON.stringify(response));
    window.location.href ='index.html'
    }).catch(error =>{
    console.error('POST request Error');
    });
}

const loginForm : HTMlElement = document.getElementById("loginform");

LoginForm.addEventListener("submit",handleLogin);