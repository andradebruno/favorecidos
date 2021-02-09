package itau.favorecidos.sboot.resource.config

import itau.favorecidos.shared.vocabulary.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["itau.favorecidos"],
    includeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, value = [UseCase::class])]
)
internal class UseCaseConfiguration