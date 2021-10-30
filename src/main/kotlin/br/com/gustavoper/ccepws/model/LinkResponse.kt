package br.com.gustavoper.ccepws.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

data class LinkResponse (
    @JsonProperty("data") val _links: LinksResponse,
)

data class LinksResponse(
            @JsonProperty("name") val name: String,
            @JsonProperty("url") val urls: List<LinkItemResponse>
)

data class LinkItemResponse(
    @JsonProperty("href") val href: String
)