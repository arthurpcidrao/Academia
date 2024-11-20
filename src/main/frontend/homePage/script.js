function menuShow() {

    let menuMobile = document.querySelector('.mobile-menu');

    if (menuMobile.classList.contains('open')) {
        menuMobile.classList.remove('open');
        document.querySelector('.icon').src = "/trabalhoAcademia/assets/header/menu_white_36dp.svg";
    } else {
        menuMobile.classList.add('open');
        document.querySelector('.icon').src = "/trabalhoAcademia/assets/header/close_white_36dp.svg";
    }
}

var radio = document.querySelector('.manual-btn');
var cont = 1;

document.getElementById('radio1').checked = true;

setInterval(() => {
    proximaImg();
}, 3000)

function proximaImg(){
    cont++;

    if(cont > 3){
        cont = 1;
    }

    document.getElementById('radio' + cont).checked = true;
}