// alinea a)
populatePhones(351, 1, 5)

// alinea b)
db.phones.drop()
populatePhones(351, 1, 200000)
db.phones.find().count()
db.phones.find({ display: /^(\+351-21)/ })
db.phones.find({ display: /^(\+351-21)/ }).count()
db.phones.find({ display: /^(\+351-22)/ }).count()
db.phones.find({ display: /^(\+351-231)/ }).count()

// alinea c)
counter(21)

// alinea d)
var capicuaNumbers = findCapicuas();

print("Números capicuas:");
capicuaNumbers.forEach(function (number) {
    print(number);
});