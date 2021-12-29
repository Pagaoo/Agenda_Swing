package business

import entity.contactEntity
import repository.contactRepo

class contactBusiness {
    private fun validateDatas(name: String, phone: String) {
        if (name == "") {
            throw Exception("O campo nome é obrigatório!")
        }
        if (phone == "") {
            throw Exception("O campo número é obrigatório!")
        }
    }

    private fun validateDelete(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("É preciso selecionar um contato antes de remover")
        }
    }

    fun saveContact(name: String, phone: String) {
        validateDatas(name, phone)
        val contact = contactEntity(name, phone)
        contactRepo.saveContact(contact)
    }

    fun deleteContact(name: String, phone: String) {
        validateDelete(name, phone)
        val contact = contactEntity(name, phone)
        contactRepo.deleteContact(contact)
    }

    fun getContactList() : MutableList<contactEntity> {
        return contactRepo.getContactList()
    }
}