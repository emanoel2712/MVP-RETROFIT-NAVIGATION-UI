package br.com.aluno.usingsomeapis.model

import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("mal_id")
    var anID: Int?,
    @SerializedName("url")
    var anURL: String?,
    @SerializedName("image_url")
    var anIMG_URL: String?,
    @SerializedName("title")
    var anTitle: String?,
    @SerializedName("airing")
    var anAiring: Boolean?,
    @SerializedName("synopsis")
    var anSynopse: String?,
    @SerializedName("type")
    var anType: String?,
    @SerializedName("episodes")
    var anQtdEpisodes: Int?,
    @SerializedName("score")
    var anScore: Double?,
    @SerializedName("start_date")
    var anStartDate: String?,
    @SerializedName("end_date")
    var anEndDate: String?,
    @SerializedName("members")
    var anQtdMembers: Double?,
    @SerializedName("rated")
    var anRated: String?
) {
}