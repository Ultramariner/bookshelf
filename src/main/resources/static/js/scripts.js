function search() {
    let url = new URL("http://localhost:8080/search");
    url.searchParams.append("category","name");
    url.searchParams.append("value",document.getElementById('value').value);
    window.location.href = url;
}