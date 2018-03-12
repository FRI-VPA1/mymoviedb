import {Component, Input, OnInit} from '@angular/core';
import {Movie} from '../movie.model';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-movie-player',
  templateUrl: './movie-player.component.html',
  styleUrls: ['./movie-player.component.scss']
})
export class MoviePlayerComponent implements OnInit {

  @Input()
  movie: Movie;

  constructor(public activeModal: NgbActiveModal) {
  }

  ngOnInit() {
  }

}
