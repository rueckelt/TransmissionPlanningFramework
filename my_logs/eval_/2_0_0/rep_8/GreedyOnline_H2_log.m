
% 2016-12-02 16:24:19

% my_logs/eval_/2_0_0/rep_8/GreedyOnline_H2_log.m
scheduling_duration_us = 4735;

% schedule
schedule_f_t_n(:,:,1) = [0; 0; 0; 0; 27; 27; 27; 19; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [31; 31; 27; 27; 0; 0; 0; 8; 27; 0; 12; 27; 16; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 0; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 4; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 27; 15; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];

% cost function results
vioSt = [0, 0, 0, 0];
vioDl = [0, 0, 0, 0];
vioNon = [0, 0, 81, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0];
vioTp = [0, 0, 0, 680];
vioLcy = [0, 0, 1215, 0];
vioJit = [0, 0, 135, 0];
cost_vio = 19679;
cost_switches = 0;
cost_ch = 140760;
costTotal = 160439;

% GreedyOnline_H2
% 
% ############### Network 0 ##############
% cap	|[0]31	|31	|31	|31	|31	|31	|31	|31	|31	|31	|[10]31	|31	|31	|31	|31	|31	|31	|31	|31	|31	|[20]31	|31	|31	|31	|31	|
% F0	|[0]	|	|	|	|27	|27	|27	|19	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F1	|[0]31	|31	|27	|27	|	|	|	|8	|27	|	|[10]12	|27	|16	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|	|4	|4	|4	|4	|4	|4	|4	|4	|[10]4	|4	|4	|4	|4	|4	|4	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|27	|[10]15	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
