from fastapi import FastAPI, HTTPException

from src import fii_utils
from src import ativo_utils

app = FastAPI()


@app.get("/")
def helf_check():
    return {"Status": "OK"}


@app.get("/ativo/{codigoAtivo}")
def buscar_informacoes_ativo(codigoAtivo):
    resumo = ativo_utils.buscar_resumo_ativo(codigoAtivo)
    if "Quote not found for ticker symbol" in resumo[codigoAtivo]:
        raise HTTPException(status_code=404, detail="Ativo não encontrado")

    return resumo


@app.get("/fiis")
def buscar_fiis():
    return fii_utils.buscar_fundos_imobiliarios()
