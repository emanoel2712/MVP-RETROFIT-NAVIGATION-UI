package br.com.aluno.usingsomeapis.model.response

import br.com.aluno.usingsomeapis.model.Anime
import br.com.aluno.usingsomeapis.model.Episode
import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("request_hash")
    var anRequestHash: String? = null,
    @SerializedName("request_cached")
    var anRequestCached: Boolean? = null,
    @SerializedName("request_cache_expiry")
    var anRequestCacheExpiry: String? = null,
    @SerializedName("results")
    var anListIn: List<Anime>? = null,
)

data class AnimeEpisodesResponse(
    @SerializedName("request_hash")
    var anRequestHash: String? = null,
    @SerializedName("request_cached")
    var anRequestCached: Boolean? = null,
    @SerializedName("request_cache_expiry")
    var anRequestCacheExpiry: String? = null,
    @SerializedName("episodes_last_page")
    var anEpLastPage: String? = null,
    @SerializedName("episodes")
    var anEpList: List<Episode>? = listOf()
)
