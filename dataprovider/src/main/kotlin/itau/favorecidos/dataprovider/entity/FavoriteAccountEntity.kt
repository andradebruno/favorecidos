package itau.favorecidos.dataprovider.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "favorite_account")
data class FavoriteAccountEntity(
    @Id
    @Column(name = "id_favorite_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idFavoriteAccount: Long = 0,

    @Column(name = "id_customer")
    val idCustomer: Long = 0,

    @Column(name = "bank_account")
    var bankAccount: String = "",

    @Column(name = "cod_agency")
    var codAgency: Int = 0,

    @Column(name = "cod_document")
    val document: String = "",

    @Column(name = "name_person")
    val namePerson: String = "",

    @Column(name = "dat_creation")
    var datCreation: LocalDateTime = LocalDateTime.now(),

    @Column(name = "dat_update")
    var datUpdate: LocalDateTime = LocalDateTime.now()
) {
    @PrePersist
    private fun onCreate() {
        datCreation = LocalDateTime.now()
    }

    @PreUpdate
    private fun onUpdate() {
        datUpdate = LocalDateTime.now()
    }
}