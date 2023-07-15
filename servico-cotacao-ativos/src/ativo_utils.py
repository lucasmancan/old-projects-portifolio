from yahooquery import Ticker


def buscar_resumo_ativo(codigoAtivo):
    petr = Ticker(codigoAtivo)
    return petr.summary_detail
