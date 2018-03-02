#@ IOService io
#@ OpService ops
#@output img
#@output result

img = io.open("https://github.com/imagejan/sandbox/raw/wip/images/nucleus.png")

// result = ops.run("math.multiply", img, 3.125)
temp = ops.run("convert.float", img)
floatImage = ops.run("create.img", temp)

temp2 = ops.run("eval", "image / 64.0", ["image": temp])
//result = ops.run("map", temp, resultOp)
floorOp = ops.op("floor", temp2.firstElement(), temp2.firstElement())
ops.run("map", floatImage, temp2, floorOp)

result = ops.run("convert.uint8", floatImage)
