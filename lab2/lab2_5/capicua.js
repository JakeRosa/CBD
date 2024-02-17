// Função para verificar se é capicua
function isCapicua(number) {
    var numStr = number.split('-')[1].toString();
    var reversedNumStr = numStr.split('').reverse().join(''); // Inverte a string
    return numStr === reversedNumStr;
}

// Função para encontrar números capicuas
function findCapicuas() {
    var nums = db.phones.find();
    var capicuas = [];

    nums.forEach(function (doc) {
        if (isCapicua(doc.display)) {
            capicuas.push(doc.display);
        }
    });

    return capicuas;
}