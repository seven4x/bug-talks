console.log('a.js')

var p = document.createElement("div");
p.id = 'projectWrapper'
let newContent = document.createTextNode("project");
p.appendChild(newContent);

var s = document.createElement("script");
s.type = "text/javascript";
s.src = "b.js";
s.async = true

p.appendChild(s)

// document.getElementById("root").appendChild(p)
// document.open();

document.write("<div id='projectWrapper'>project</div><script type='text/javascript' src='b.js'> </script>")

// document.close()
/**
 * //总结：异步js不允许直接使用document.write，需要先document.open 但是open会清空文档
 * * 非异步不推荐使用。因为document.write会阻塞绘制，需要先下载js解析dom...
 *
 */
