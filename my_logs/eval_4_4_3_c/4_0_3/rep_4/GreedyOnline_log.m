
% 2016-05-05 18:28:59

% my_logs/eval_4_4_3_c/4_0_3/rep_4/GreedyOnline_log.m
scheduling_duration_us = 335378;

% schedule
schedule_f_t_n(:,:,1) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 87, 0, 0; 0, 0, 0, 0, 0, 87, 0, 0; 0, 0, 0, 0, 0, 0, 0, 32; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,2) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,3) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 8, 0, 0, 0, 0, 0, 0, 0; 8, 0, 0, 0, 0, 0, 0, 0; 0, 0, 8, 0, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 8; 0, 0, 0, 0, 0, 0, 0, 8; 0, 0, 0, 0, 0, 0, 8, 0; 0, 0, 0, 0, 0, 0, 8, 0; 0, 0, 0, 0, 0, 0, 8, 0; 0, 0, 0, 0, 0, 0, 3, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,4) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 48, 0, 0, 0, 0, 0, 0, 0; 36, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 18, 0, 0, 0, 0; 0, 0, 0, 18, 0, 0, 0, 0; 0, 0, 0, 18, 0, 0, 0, 0; 0, 0, 0, 7, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 22; 0, 0, 0, 0, 0, 0, 0, 22; 0, 23, 0, 0, 0, 0, 0, 0; 0, 23, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,5) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 44, 0, 0, 0, 0, 0, 0, 0; 48, 0, 0, 0, 0, 0, 0, 0; 48, 0, 0, 0, 0, 0, 0, 0; 31, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,6) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 0, 0, 33, 0; 0, 0, 0, 0, 0, 0, 83, 0; 0, 0, 0, 0, 0, 0, 70, 0; 48, 0, 0, 0, 0, 0, 0, 0; 48, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 3, 0; 27, 0, 0, 0, 0, 0, 0, 0; 35, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,7) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 13; 0, 0, 0, 0, 0, 0, 0, 13; 0, 0, 0, 0, 0, 0, 0, 13; 0, 13, 0, 0, 0, 0, 0, 0; 0, 13, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 13, 0; 0, 0, 0, 0, 0, 0, 13, 0; 0, 0, 0, 0, 0, 0, 13, 0; 0, 0, 0, 0, 0, 0, 13, 0; 13, 0, 0, 0, 0, 0, 0, 0; 5, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,8) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 40, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 15, 0, 0, 0; 36, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 3, 0, 0, 0, 0; 0, 0, 0, 18, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,9) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,10) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,11) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 8, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 8; 0, 0, 0, 0, 0, 0, 0, 8; 0, 0, 0, 0, 0, 0, 8, 0; 0, 0, 0, 0, 0, 0, 8, 0; 0, 0, 0, 0, 0, 0, 8, 0; 0, 0, 0, 0, 0, 0, 8, 0; 0, 0, 0, 0, 0, 0, 8, 0; 0, 0, 0, 0, 0, 0, 8, 0; 8, 0, 0, 0, 0, 0, 0, 0; 8, 0, 0, 0, 0, 0, 0, 0; 8, 0, 0, 0, 0, 0, 0, 0; 2, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,12) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 40, 0, 0, 0, 0, 0, 0, 0; 0, 0, 50, 0, 0, 0, 0, 0; 0, 0, 58, 0, 0, 0, 0, 0; 0, 0, 58, 0, 0, 0, 0, 0; 0, 0, 0, 30, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,13) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 48, 0, 0, 0, 0, 0, 0, 0; 48, 0, 0, 0, 0, 0, 0, 0; 4, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,14) = [0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 17, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 19; 0, 0, 0, 0, 0, 0, 0, 51; 0, 0, 0, 0, 0, 0, 0, 25; 0, 0, 0, 0, 0, 0, 75, 0; 0, 0, 0, 0, 0, 0, 78, 0; 0, 0, 0, 0, 0, 0, 25, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,15) = [0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 12, 0, 0, 0; 12, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 12, 0, 0, 0, 0; 0, 0, 0, 12, 0, 0, 0, 0; 12, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 12, 0, 0, 0, 0; 0, 0, 0, 12, 0, 0, 0, 0; 0, 0, 0, 12, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 12; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];
schedule_f_t_n(:,:,16) = [48, 0, 0, 0, 0, 0, 0, 0; 48, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 27, 0, 0, 0; 48, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0];

% cost function results
vioSt = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioDl = [0, 0, 60, 207, 0, 0, 100, 162, 189, 0, 40, 210, 0, 0, 0, 384];
vioNon = [0, 1812, 0, 12744, 0, 242, 0, 34476, 4080, 2032, 0, 27120, 0, 0, 0, 17220];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioLcy = [0, 0, 72, 0, 0, 0, 72, 0, 0, 0, 144, 0, 0, 0, 231, 0];
vioJit = [0, 0, 567, 0, 0, 0, 344, 0, 0, 0, 464, 0, 0, 0, 424, 0];
cost_vio = 675671;
cost_switches = 35000;
cost_ch = 830850;
costTotal = 1541521;

% GreedyOnline
% 
% ############### Network 0 ##############
% cap	|[0]48	|48	|48	|48	|48	|48	|48	|48	|48	|48	|[10]48	|48	|48	|48	|48	|48	|48	|48	|48	|48	|[20]48	|48	|48	|48	|48	|
% F2	|[0]	|	|8	|8	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|48	|36	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F4	|[0]	|	|	|	|	|	|	|	|	|	|[10]44	|48	|48	|31	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F5	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|48	|48	|	|[20]27	|35	|	|	|	|
% F6	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]13	|5	|	|	|	|
% F7	|[0]	|	|40	|	|36	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F10	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]8	|8	|8	|2	|	|
% F11	|[0]	|	|	|40	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F12	|[0]	|	|	|	|	|	|	|	|48	|48	|[10]4	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F13	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|17	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F14	|[0]	|	|	|	|12	|	|	|12	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F15	|[0]48	|48	|	|	|	|48	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% ############### Network 1 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|36	|36	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|23	|23	|	|	|	|	|[20]	|	|	|	|	|
% F6	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|13	|13	|	|	|	|	|[20]	|	|	|	|	|
% ############### Network 2 ##############
% cap	|[0]0	|0	|0	|0	|58	|58	|58	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|
% F2	|[0]	|	|	|	|8	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F11	|[0]	|	|	|	|50	|58	|58	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% ############### Network 3 ##############
% cap	|[0]0	|0	|0	|0	|0	|23	|46	|46	|46	|46	|[10]46	|23	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|
% F2	|[0]	|	|	|	|	|8	|8	|8	|8	|8	|[10]8	|8	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|18	|18	|[10]18	|7	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F7	|[0]	|	|	|	|	|3	|18	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F10	|[0]	|	|	|	|	|	|8	|8	|8	|8	|[10]8	|8	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F11	|[0]	|	|	|	|	|	|	|30	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F14	|[0]	|	|	|	|	|12	|12	|	|12	|12	|[10]12	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% ############### Network 4 ##############
% cap	|[0]27	|27	|27	|27	|27	|27	|27	|27	|27	|27	|[10]27	|27	|27	|27	|27	|27	|27	|27	|27	|27	|[20]27	|27	|27	|27	|27	|
% F4	|[0]	|	|	|	|	|	|	|	|27	|27	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F5	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|27	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F7	|[0]	|	|	|15	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F8	|[0]	|	|	|	|	|	|	|	|	|	|[10]27	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F12	|[0]	|	|	|	|	|27	|27	|27	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F13	|[0]27	|27	|	|	|	|	|	|	|	|	|[10]	|27	|27	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F14	|[0]	|	|	|12	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F15	|[0]	|	|27	|	|27	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% ############### Network 5 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|87	|87	|87	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|87	|87	|	|	|	|	|	|	|[20]	|	|	|	|	|
% ############### Network 6 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|49	|99	|99	|99	|99	|49	|[20]0	|0	|0	|0	|0	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|8	|8	|8	|3	|	|	|[20]	|	|	|	|	|
% F5	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|33	|83	|70	|	|	|3	|[20]	|	|	|	|	|
% F6	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|13	|13	|13	|13	|[20]	|	|	|	|	|
% F10	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|8	|8	|8	|8	|8	|8	|[20]	|	|	|	|	|
% F13	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|75	|78	|25	|[20]	|	|	|	|	|
% ############### Network 7 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|25	|51	|51	|51	|51	|25	|0	|0	|0	|[20]0	|0	|0	|0	|0	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|32	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|8	|8	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|22	|22	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F6	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|13	|13	|13	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F10	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|8	|8	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F13	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|19	|51	|25	|	|	|	|[20]	|	|	|	|	|
% F14	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|12	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
