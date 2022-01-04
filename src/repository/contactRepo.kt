package repository

import entity.contactEntity

class contactRepo {

    companion object {
        private val contactList = mutableListOf<contactEntity>()

        fun saveContact(contact: contactEntity) {
            contactList.add(contact)
        }

        fun deleteContact(contact: contactEntity) {

            var index = 0
            for (item in contactList.withIndex()) { // Vai pegar o valor do name e phone e comparar com o do contato já salvo
                if (item.value.name == contact.name && item.value.phone == contact.phone) {
                    index = item.index // se forem iguais, é esse que vai ser removido e será atribuido a var index
                    break
                }
            }
            contactList.removeAt(index); // remove o index salvo nesta variavel
        }

        fun getContactList(): MutableList<contactEntity> {
            return contactList
        }
    }
}