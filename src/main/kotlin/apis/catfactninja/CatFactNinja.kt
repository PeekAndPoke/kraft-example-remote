package io.peekandpoke.kraft.examples.helloworld.apis.catfactninja

import de.peekandpoke.ultra.common.remote.ApiClient
import de.peekandpoke.ultra.common.remote.TypedApiEndpoint
import de.peekandpoke.ultra.common.remote.call
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class CatFactNinja {

    @Serializable
    data class Fact(
        val fact: String,
        val length: Int,
    )

    @Serializable
    data class Paged<T>(
        val current_page: Int,
        val data: List<T>,
    )

    class Client(config: Config) : ApiClient(config) {
        companion object {
            val GetFact = TypedApiEndpoint.Get(
                "/fact",
                response = Fact.serializer(),
            )
            val GetFacts = TypedApiEndpoint.Get(
                "/facts",
                response = Paged.serializer(Fact.serializer())
            )
        }

        fun getFact(): Flow<Fact> = call(
            GetFact()
        )

        fun getFacts(limit: Int): Flow<Paged<Fact>> = call(
            GetFacts(
                "limit" to limit.toString()
            )
        )
    }

    private val apiConfig = ApiClient.Config(
        baseUrl = "https://catfact.ninja",
        codec = Json {
            ignoreUnknownKeys = true
        },
    )

    val apiClient = Client(apiConfig)
}
