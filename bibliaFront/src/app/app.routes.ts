import { Routes } from '@angular/router';
import { Buscar } from './buscar/buscar';
import { Home } from './home/home';

export const routes: Routes = [{path:"",component:Home},{path:"home",component:Home},{path:"buscar",component:Buscar}];
