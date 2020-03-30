async function logout() {
    await fetch("/logout", {
        method:'POST',
        headers: {
            'Content-type': 'application/json;charset=utf-8',
            'Data-type': 'text/html'
        },
    });
    window.location.replace("/");
}