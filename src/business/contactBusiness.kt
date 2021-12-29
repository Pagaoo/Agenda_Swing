package business

class contactBusiness {
    fun validateDatas(name: String, phone: String) {
        if (name == "") {
            throw Exception("O campo nome é obrigatório!")
        }
        if (phone == "") {
            throw Exception("O campo número é obrigatório!")
        }
    }

    fun validateDelete(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("É preciso selecionar um contato antes de remover")
        }
    }

    fun saveContact(name: String, phone: String) {
        validateDatas(name, phone)
    }

    fun deleteContact(name: String, phone: String) {
        validateDelete(name, phone)
    }
}