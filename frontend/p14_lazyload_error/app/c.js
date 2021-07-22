console.log("c.js")

var app = document.createElement("div");
app.id='app'
let appContent = document.createTextNode("real app runtime");
app.appendChild(appContent);

document.getElementById("projectWrapper").appendChild(app)
