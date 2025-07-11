const canvas = document.getElementById("bubbleCanvas");
const ctx = canvas.getContext("2d");

canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

let mouse = {
  x: canvas.width / 2,
  y: canvas.height / 2,
};

window.addEventListener("resize", () => {
  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;
});

window.addEventListener("mousemove", (e) => {
  mouse.x = e.x;
  mouse.y = e.y;
});

window.addEventListener("click", () => {
  randomizeColors();
});

let colors = ["#FFB6C1", "#FFC0CB", "#ADD8E6", "#E0FFFF", "#FFD700"];

function randomizeColors() {
  colors = Array.from({ length: 5 }, () =>
    `hsl(${Math.random() * 360}, 100%, 80%)`
  );
}

class Bubble {
  constructor() {
    this.reset();
  }

  reset() {
    this.x = mouse.x + Math.random() * 80 - 40;
    this.y = mouse.y + Math.random() * 80 - 40;
    this.radius = Math.random() * 10 + 3;
    this.color = colors[Math.floor(Math.random() * colors.length)];
    this.velocityX = (Math.random() - 0.5) * 2;
    this.velocityY = (Math.random() - 0.5) * 2;
    this.life = 100;
  }

  update() {
    this.x += this.velocityX;
    this.y += this.velocityY;
    this.life--;
    if (this.life <= 0) this.reset();
  }

  draw() {
    ctx.beginPath();
    ctx.globalAlpha = this.life / 100;
    ctx.fillStyle = this.color;
    ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2);
    ctx.fill();
    ctx.globalAlpha = 1;
  }
}

let bubbles = [];
for (let i = 0; i < 100; i++) {
  bubbles.push(new Bubble());
}

function animate() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  bubbles.forEach((bubble) => {
    bubble.update();
    bubble.draw();
  });
  requestAnimationFrame(animate);
}

animate();

function addToCart(name) {
  alert(`${name} added to your cart! 🛒`);
}
