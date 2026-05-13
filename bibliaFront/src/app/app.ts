import { AfterViewInit, Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements AfterViewInit{
  ngAfterViewInit(): void {
    const wrapper = document.getElementById('dailyVersesWrapper');
    if (wrapper) {
    const script= document.createElement('script');
    script.src="https://dailyverses.net/get/verse.js?language=rvr60";
    script.async=true;
    script.defer=true;
    document.body.appendChild(script);
    }
  }
  
}
