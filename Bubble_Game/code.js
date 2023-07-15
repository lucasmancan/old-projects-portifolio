





//variáveis do jogo
var numbolas = 0;
var tempoDeJogo = 0;
var tempoDeTroca = 0;
var score = 0;
var bola = 0;
var tamanho = 0;
var container = 0;
var id =0;

var width=0;
var height=0;
var left = 0;
var top = 0;
var timeId= 0
var inicio =0;
var fim = 0;
var textoFim = document.getElementById("fimJogo");
var textoPontuacao = document.getElementById("pontuacao");
//variáveis do jogo

window.onload = function(){
  width = innerWidth;
  height = innerHeight;
  
}

function start(difficult) {

  document.getElementById('config').style.display = "none";
  document.getElementById('logo').style.display = "none";
  
 
  switch (difficult) {
    case "1":
    document.getElementById("fimJogo").style.display = "none";
    document.getElementById("pontuacao").style.display = "block";
      numbolas = 6;
      tempoDeJogo = 15;
      tempoDeTroca = 1500;
      score = 0;
      inicio = new Date().getTime();
      document.getElementById("score").innerHTML = score;
      if(id< numbolas){
        criarBola(numbolas);
      }else{
        aparecerBolas(numbolas);
      }
      timeId = setInterval(aparecerBolas, tempoDeTroca);
      break;

    case "2":
    document.getElementById("fimJogo").style.display = "none";
    document.getElementById("pontuacao").style.display = "block";
      numbolas = 4;
      tempoDeJogo = 15;
      tempoDeTroca = 1000;
      score = 0;
      document.getElementById("score").innerHTML = score;
      inicio = new Date().getTime();
      if(id< numbolas){
        criarBola(numbolas);
      }else{
        aparecerBolas(numbolas);
      }
      timeId = setInterval(aparecerBolas, tempoDeTroca);
      break;

    case "3":
    document.getElementById("fimJogo").style.display = "none";
    document.getElementById("pontuacao").style.display = "block";
      numbolas = 3;
      tempoDeJogo = 15;
      tempoDeTroca =  500;
      score = 0;
      document.getElementById("score").innerHTML = score;
      inicio = new Date().getTime();
      if(id< numbolas){
        criarBola(numbolas);
      }else{
        aparecerBolas(numbolas);
      }
      timeId = setInterval(aparecerBolas, tempoDeTroca);
     
      break;

    default:
      document.innerHTML = "Selecione uma opção";
  }
}
function aparecerBolas(){
 
  for (var i = 0; i < numbolas; i++) {
    
    mudarBola(i);
  }
}

  function FimJogo(){
   
    document.getElementById('logo').style.display = "block";
    document.getElementById('config').style.display = "block";
   
    clearInterval(timeId);
    
    for(var i =0; i <numbolas; i++){
      desaparecerForma(i);

    }
    if(score == 0){
      document.getElementById("fimJogo").innerHTML = "Ops, não foi sua melhor partida né?";
    }else if(score <= 10){
      document.getElementById("fimJogo").innerHTML = "Poxa, você conseguiu "+score+" pontos, tenho certeza que consegue mais!";
    }else if(score > 10 && score <=20){
      document.getElementById("fimJogo").innerHTML = "Parabéns, você foi muito bem e conseguiu "+score+" pontos!";
    }else if(score > 20){
      document.getElementById("fimJogo").innerHTML = "Excelente, você conseguiu "+score+" pontos, já pode se achar o maioral!!";
    }
    
    document.getElementById("fimJogo").style.display = "block";
   document.getElementById("pontuacao").style.display = "none";
  }
function Bola() {
  bola = document.createElement('div');
  bola.setAttribute("class", "bola");
  bola.setAttribute("id", id);
  // Criar elemento
  bola.setAttribute("onclick", "desaparecerForma("+id+");");
  
  document.body.appendChild(bola);
  mudarBola(id);
  id++;
}




function mudarBola(id) {
 
  fim = new Date().getTime();
  if((fim-inicio)/1000 >= tempoDeJogo ){
    FimJogo();
  }else{
    var bola = document.getElementById(id);
    if(width <= 768){
      tamanho = (Math.floor((Math.random() * 100) + 20));
      
    }else{
      tamanho = (Math.floor((Math.random() * 200) + 50));
    }
    
   
    bola.style.top = Math.floor(Math.random()*(height-tamanho))+"px";
    bola.style.left = Math.floor(Math.random()*(width-tamanho))+ "px";
    bola.style.backgroundColor = getRandomColor();
    bola.style.display = "block";
    bola.style.width =  tamanho + "px";
    bola.style.height= tamanho + "px";
  }
 
  
}
function criarBola(numbolas) {
  for (var i = id; i < numbolas; i++) {
    Bola(); 
  }
}

function desaparecerForma(id) {
  
  document.getElementById(id).style.display = "none";
  if((fim-inicio)/1000 >= tempoDeJogo){
    
  }else{
    score++;
  }
  
  document.getElementById("score").innerHTML = score;
  
}

function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function RandomShape(width) {
  if (width <= 150) {
    return 0;
  } else {
    return 50;
  }
}
