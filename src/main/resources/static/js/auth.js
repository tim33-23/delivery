async function auth() {
    let login = document.getElementById('login').value;
    let password = document.getElementById('password').value;
    let user = {login: login, password: password};
    let prom = await fetch("/login", {
        method: 'POST',
        headers: {
            'Content-type': 'application/json;charset=utf-8',
            'Data-type': 'text/html'
        },
        body: JSON.stringify(user)
    });
    let s1 = await prom.text();
    if (s1 === "OK") {
        window.location.replace("/main.html");
    } else if (s1 === "No") {
        alert("Не правильное имя пользователя или пароль!");
    } else {
        alert(s1);
    }
}

async function reg() {
    let login = document.getElementById('login').value;
    let password = document.getElementById('password').value;
    let vpassword = document.getElementById('vpassword').value;
    let user = {login: login, password: password, vpassword: vpassword}
    let promise =await fetch("/registration", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
            'Data-type': 'text/html'
        },
        body: JSON.stringify(user)
    });
    let s1 = await promise.text();
    if (s1 === "OK") {
        window.location.replace("/main.html");
    } else {
        alert(s1);
    }
}