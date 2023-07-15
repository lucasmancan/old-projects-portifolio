package br.com.lucasmancan.dojojpa.jpaentitiy

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class VendaItemId(

    //https://www.baeldung.com/jpa-composite-primary-keys
    @Column(name = "venda_id")
    var vendaId: Int? = null,

    @Column(name = "produto_id")
    var produtoId: Int? = null
) : Serializable