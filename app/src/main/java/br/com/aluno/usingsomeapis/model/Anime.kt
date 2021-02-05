package br.com.aluno.usingsomeapis.model

import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("mal_id")
    var anID: Int? = null,
    @SerializedName("url")
    var anURL: String? = null,
    @SerializedName("image_url")
    var anIMG_URL: String? = null,
    @SerializedName("title")
    var anTitle: String? = null,
    @SerializedName("airing")
    var anAiring: Boolean? = null,
    @SerializedName("synopsis")
    var anSynopse: String? = null,
    @SerializedName("type")
    var anType: String? = null,
    @SerializedName("episodes")
    var anQtdEpisodes: Int? = null,
    @SerializedName("score")
    var anScore: Double? = null,
    @SerializedName("start_date")
    var anStartDate: String? = null,
    @SerializedName("end_date")
    var anEndDate: String? = null,
    @SerializedName("members")
    var anQtdMembers: Double? = null,
    @SerializedName("rated")
    var anRated: String? = null
) {
}