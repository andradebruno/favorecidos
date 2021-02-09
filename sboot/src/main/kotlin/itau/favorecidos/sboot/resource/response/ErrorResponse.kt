package itau.favorecidos.sboot.resource.response

data class ErrorResponse(
    val errorStatus: Int,
    val errorMessage: String
)
