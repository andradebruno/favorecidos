package itau.favorecidos.sboot.resource.config

import itau.favorecidos.dataprovider.FavoriteAccountRepositoryImpl
import itau.favorecidos.dataprovider.repository.FavoriteAccountJpaRepository
import itau.favorecidos.domain.repository.FavoriteAccountRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["itau.favorecidos.dataprovider"])
class FavoriteAccountProviderConfig {

    @Bean
    @Primary
    fun loadFavoriteCreate(favoriteAccountJpaRepository: FavoriteAccountJpaRepository) : FavoriteAccountRepository {
        return FavoriteAccountRepositoryImpl(favoriteAccountJpaRepository)
    }
}