package itau.favorecidos.sboot.resource.resource

import itau.favorecidos.application.CreateFavoriteUseCase
import itau.favorecidos.application.DeleteFavoriteUseCase
import itau.favorecidos.application.FindFavoriteUseCase
import itau.favorecidos.application.UpdateFavoriteUseCase
import itau.favorecidos.application.request.CreateRequest
import itau.favorecidos.application.request.UpdateRequest
import itau.favorecidos.application.response.FavoriteAccountResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/favorite"])
class FavoriteAccountResource(
    private val createFavoriteUseCase: CreateFavoriteUseCase,
    private val findFavoriteUseCase: FindFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    private val updateFavoriteUseCase: UpdateFavoriteUseCase
) {

    @PostMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun create(@RequestBody request: CreateRequest): FavoriteAccountResponse {
        return createFavoriteUseCase.execute(request)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) {
        this.deleteFavoriteUseCase.execute(id)
    }

    @GetMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun find(@PathVariable("id") idCustomer: Long): List<FavoriteAccountResponse> {
        return this.findFavoriteUseCase.execute(idCustomer)
    }

    @PutMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable("id") idFavoriteAccount: Long,
        @RequestBody request: UpdateRequest
    ): FavoriteAccountResponse {
        return this.updateFavoriteUseCase.execute(idFavoriteAccount, request)
    }

}