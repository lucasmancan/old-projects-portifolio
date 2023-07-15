var $target = $('.anime');
var animationClass = 'anime-start';
var offset = $(window).height() * 3 / 4;


function animeScroll() {
    var documentTop = $(document).scrollTop();


    $target.each(function () {
        var itemTop = $(this).offset().top;

        if (documentTop > itemTop - offset) {
            $(this).addClass(animationClass);
        } else {
            $(this).removeClass(animationClass);
        }
    })

}
function mensagemLink(){
    var mensagemLink=  $('#mensagem-link').offset().top; 
    var documentTop = $('#contato').offset().top;
    
    if(mensagemLink > documentTop){
$('#mensagem-link').fadeOut();
    }else{
        $('#mensagem-link').fadeIn();
    }
}
animeScroll();
$(document).scroll(function () {
    animeScroll();
    mensagemLink();
})


var typed = new Typed('#typed', {
    strings: ["Olá", "Seja bem-vindo ao meu site!", "Meu nome é ...", "Lucas Frederico Mançan"],
    typeSpeed: 90
});


$('.btn').on('click', function () {

    var seletor = $(this).attr("href");
    posicao = $(seletor).offset().top;
    $("html, body").animate({
        scrollTop: posicao
    }, 1000)
})


$('#btn-contato').on('click', function () {

    var seletor = $(this).attr("href");
    posicao = $(seletor).offset().top;
    $("html, body").animate({
        scrollTop: posicao
    }, 1000)
})


$("#formulario").on("submit", function (evento) {

    var isValid = true;
    var campos = $('.form-control');

    for (var i = 0; i < campos.length; i++) {

       
        if (campos[i].value == "") {
            campos[i].classList.add("erro-form");
            isValid = false;

        } else {
            campos[i].classList.remove("erro-form");

        }

    }
    if(!isEmail(campos[1].value)){
        campos[1].classList.add("erro-form");
        isValid = false;
    }
    if (isValid == true) {
        return true;
    } else {
        return false;
    }
})



function isEmail(email) {
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email);
  }

