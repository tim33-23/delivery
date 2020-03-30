async function send() {
    let pro = await fetch("/mainData", {
        method: 'POST',
        headers: {
            'Content-type': 'application/json;charset=utf-8',
            'Data-type': 'text/html'
        },
    });
    if (pro.status === 200) {
        let login = await pro.text();
        let s1 = document.getElementById("greeting");
        s1.textContent = s1.textContent + " " + login;
    } else if(pro.status === 400) {
        if(pro.headers.get("cause") === "usernotfound"){
            window.location.replace("/");
        }
    }
}