package itau.favorecidos.application

interface DeleteFavoriteUseCase {

    fun execute(idFavoriteAccount: Long)
}