package io.peekandpoke.kraft.examples.helloworld.apis.agifyio

import de.peekandpoke.ultra.common.remote.ApiClient
import de.peekandpoke.ultra.common.remote.TypedApiEndpoint
import de.peekandpoke.ultra.common.remote.call
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class AgifyIo {

    @Serializable
    data class Result(
        val name: String,
        val age: Int,
        val count: Int,
    )

    class Client(config: Config) : ApiClient(config) {
        companion object {
            val Get = TypedApiEndpoint.Get(
                "",
                response = Result.serializer(),
            )
        }

        fun get(name: String): Flow<Result> = call(
            Get(
                "name" to name
            )
        )
    }

    private val apiConfig = ApiClient.Config(
        baseUrl = "https://api.agify.io/",
        codec = Json {
            ignoreUnknownKeys = true
        },
    )

    val apiClient = Client(apiConfig)
}
