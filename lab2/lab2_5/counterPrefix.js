counter = function (prefix) {
    return db.phones.find({ "components.prefix": prefix }).count()
}