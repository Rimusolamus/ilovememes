package cz.rimu.ilovememes.repositories

import cz.rimu.ilovememes.rest.Api
import cz.rimu.ilovememes.rest.model.Hot
import java.net.ConnectException

class MainRepository(private val api: Api) {
    suspend fun getAllFunny(): Hot = try {
        api.getAllFunny()
    } catch (e: ConnectException) {
        Hot(null)
    } catch (e: Exception) {
        Hot(null)
    }
}