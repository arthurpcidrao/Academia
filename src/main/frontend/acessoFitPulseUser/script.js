document.addEventListener('mousedown', function(event) {

    const buttons = document.querySelectorAll('.botao-opcao');
    let clickedOutside = true;

    buttons.forEach(button => {
        if (button.contains(event.target)) {
            clickedOutside = false;
        }
    });

    if (clickedOutside) {
        event.preventDefault();
    }
});