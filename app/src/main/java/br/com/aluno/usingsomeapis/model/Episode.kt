package br.com.aluno.usingsomeapis.model

import com.google.gson.annotations.SerializedName

class Episode(
    @SerializedName("episode_id")
    var epID: Int? = null,
    @SerializedName("title")
    var epTitle: String? = null,
    @SerializedName("title_japanese")
    var epTitleJapanese: String? = null,
    @SerializedName("title_romanji")
    var epTitleRomanji: String? = null,
    @SerializedName("aired")
    var epAired: String? = null,
    @SerializedName("filler")
    var epFiller: Boolean? = false,
    @SerializedName("video_url")
    var epVideoURL: String? = null,
    @SerializedName("forum_url")
    var epForumURL: String? = null
)
