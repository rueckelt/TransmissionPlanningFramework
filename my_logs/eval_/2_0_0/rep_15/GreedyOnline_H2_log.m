
% 2016-12-02 16:24:23

% my_logs/eval_/2_0_0/rep_15/GreedyOnline_H2_log.m
scheduling_duration_us = 1843;

% schedule
schedule_f_t_n(:,:,1) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 56; 56; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [56; 56; 56; 56; 56; 56; 56; 56; 56; 18; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 33; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];

% cost function results
vioSt = [0, 0, 0, 0];
vioDl = [0, 0, 0, 0];
vioNon = [0, 0, 924, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0];
vioTp = [0, 0, 0, 544];
vioLcy = [0, 0, 1904, 0];
vioJit = [0, 0, 2448, 0];
cost_vio = 61300;
cost_switches = 0;
cost_ch = 242550;
costTotal = 303850;

% GreedyOnline_H2
% 
% ############### Network 0 ##############
% cap	|[0]60	|60	|60	|60	|60	|60	|60	|60	|60	|60	|[10]60	|60	|60	|60	|60	|60	|60	|60	|60	|60	|[20]60	|60	|60	|60	|60	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|56	|56	|	|	|	|[20]	|	|	|	|	|
% F1	|[0]56	|56	|56	|56	|56	|56	|56	|56	|56	|18	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]4	|4	|4	|4	|4	|4	|4	|4	|4	|4	|[10]4	|4	|4	|4	|4	|4	|4	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|33	|	|	|	|	|	|	|[20]	|	|	|	|	|
